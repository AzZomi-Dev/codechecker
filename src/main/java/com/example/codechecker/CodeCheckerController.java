package com.example.codechecker;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CodeCheckerController {

    @GetMapping("/")
    public String getHomePage(Model model) {
        model.addAttribute("codeRequest", new CodeRequest());
        return "index"; // Thymeleaf template
    }

    @PostMapping("/check-code")
    @ResponseBody
    public ResponseEntity<CodeCheckResponse> checkCode(@RequestBody CodeRequest codeRequest) {
        List<String> errors = new ArrayList<>();
        validateCode(codeRequest.getCode(), errors);

        return ResponseEntity.ok(new CodeCheckResponse(errors));
    }

    private void validateCode(String code, List<String> errors) {
        if (!code.trim().endsWith(";")) {
            errors.add("Code should end with a semicolon.");
        }

        // Example: More complex validation can be added here
    }

    // Code request object
    public static class CodeRequest {
        private String code;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }

    // Code validation response object
    public static class CodeCheckResponse {
        private List<String> errors;

        public CodeCheckResponse(List<String> errors) {
            this.errors = errors;
        }

        public List<String> getErrors() {
            return errors;
        }

        public void setErrors(List<String> errors) {
            this.errors = errors;
        }
    }
}
