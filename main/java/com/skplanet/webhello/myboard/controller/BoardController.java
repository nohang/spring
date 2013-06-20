package com.skplanet.webhello.myboard.controller;

import com.skplanet.webhello.myboard.entity.Board;
import com.skplanet.webhello.myboard.entity.User;
import com.skplanet.webhello.myboard.service.BoardService;
import com.skplanet.webhello.myboard.service.UserService;
import com.skplanet.webhello.myboard.validator.BoardValidator;
import com.skplanet.webhello.myboard.validator.SignUpValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: skplanet
 * Date: 13. 6. 9.
 * Time: 오후 8:41
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class BoardController {

    @Autowired
    BoardService boardService;
    @Autowired
    UserService userService;

    @RequestMapping(value="/board/list",method = RequestMethod.GET)
    private String BoardList(Model model){
        List<Board> boards = boardService.getBoards();
        model.addAttribute("boards",boards);
        return "boardList";
    }
    @RequestMapping(value = "/board/insertForm",method = RequestMethod.GET)
    private String BoardInsert(){
        return "boardInsert";
    }
    @RequestMapping(value = "/board/detail",method = RequestMethod.GET)
    private String BoardDetail(@RequestParam("id") Integer id ,Model model){
        Board board = boardService.matchingId(id);
        model.addAttribute("board",board);
        return "boardDetail";
    }

    @RequestMapping(value = "/board/updateForm",method = RequestMethod.GET)
    private String BoardUpdateForm(@RequestParam("id") Integer id, Model model){
        Board board = boardService.matchingId(id);
        model.addAttribute("board",board);
        return "boardUpdate";
    }

    @RequestMapping(value = "/board/update",method = RequestMethod.POST)
    private String BoardUpdate( Board board, BindingResult result){
        new BoardValidator().validate(board, result);
        if(result.hasErrors()){
            return "boardUpdate";
        }
        boardService.updateBoard(board);
        return "redirect:/board/list";
    }

    @RequestMapping(value = "/board/save",method = RequestMethod.POST)
    private String BoardSave(Board board, BindingResult result){
        boardService.addBoard(board);
        new BoardValidator().validate(board,result);
        if(result.hasErrors()){
            return "boardInsert";
        }
        return "redirect:/board/list";
    }
    @RequestMapping(value = "/board/delete",method = RequestMethod.POST)
    private String BoardDelete(@RequestParam("id") Integer id){
        boardService.deleteBoard(id);
        return "redirect:/board/list";
    }

    @RequestMapping(value = "/loginForm",method = RequestMethod.GET)
    private String BoardLoginForm(@CookieValue(value = "userid", required = false) String userid,Model model){
        model.addAttribute("userid",userid);
        return "boardLogin";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    private String BoardLogin(HttpServletRequest request, HttpServletResponse response, Model model){
        String userid = request.getParameter("userid");
        Cookie cookie = new Cookie("userid",userid);
        if(request.getParameter("checked")!=null){

            cookie.setMaxAge(60*60*24*30);
            response.addCookie(cookie);
        }
        else{
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }

        if(request.getParameter("userid").equals("a") && request.getParameter("pw").equals("b")){
            System.out.println("1");
            HttpSession session = request.getSession();
            session.setAttribute("userid",userid);
            if(request.getServletContext().getAttribute("connect")==null){
                request.getServletContext().setAttribute("connect",new Integer(0));
            }
            int connect = (Integer)request.getServletContext().getAttribute("connect")+1;
            request.getServletContext().setAttribute("connect",new Integer(connect));
        }
        return "redirect:/board/list";
    }
    @RequestMapping(value = "/signUpForm",method = RequestMethod.GET)
    private String BoardSignUpForm(){
        return "boardSignUp";
    }
    @RequestMapping(value = "/signUp",method = RequestMethod.POST)
    private String BoardSignUp(User user, BindingResult result){

        new SignUpValidator().validate(user,result);
        if(result.hasErrors()){
            System.out.println("error!!");
            System.out.println("result = " + result);
            return "boardSignUp";
        }
        userService.addUser(user);
        return "redirect:/loginForm";
    }
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    private String BoardLogout(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        session.invalidate();
        return "redirect:/loginForm";
    }




}
