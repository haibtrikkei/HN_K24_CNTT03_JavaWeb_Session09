package session_cookie.demo_javaweb_session09.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import session_cookie.demo_javaweb_session09.model.dto.UserLogin;

import java.time.LocalDateTime;

@Controller
@RequestMapping({"/", "/auth"})
public class HomeController {

    @GetMapping({"/", "/login"})
    public String login(Model model) {
        model.addAttribute("userLogin", new UserLogin());
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(@ModelAttribute("userLogin") UserLogin userLogin, HttpSession session, Model model, @CookieValue(value = "lastLogin", required = false) String lastLogin) {
        if (userLogin.getUsername().equals("admin") && userLogin.getPassword().equals("1234")) {
            session.setAttribute("username", userLogin.getUsername());

            if (lastLogin != null) {
                lastLogin = "Lần đăng nhập gần nhât của user: " + userLogin.getUsername() + " là: " + lastLogin;
            }
            model.addAttribute("lastLogin", lastLogin);
            return "home";
        } else {
            //đăng nhập không thành công
            model.addAttribute("message", "Sai username hoặc password!");
            model.addAttribute("userLogin", userLogin);
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session, HttpServletResponse response, Model model) {
        session.invalidate();

        //Sử dụng cookie để lưu thông tin đăng nhập lần cuối
        LocalDateTime localDateTime = LocalDateTime.now();

        String lastLogin = localDateTime.toString();
        Cookie cLastLogin = new Cookie("lastLogin", lastLogin);
        cLastLogin.setMaxAge(360 * 24 * 60 * 60);
        response.addCookie(cLastLogin);

//        return "redirect:/login"; //Gọi lại hàm login trong controller
        model.addAttribute("userLogin", new UserLogin());
        return "login";
    }

}
