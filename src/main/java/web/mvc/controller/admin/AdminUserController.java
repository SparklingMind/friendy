package web.mvc.controller.admin;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.mvc.dto.user.*;
import web.mvc.enums.users.State;
import web.mvc.service.admin.AdminUserService;
import web.mvc.service.user.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/users")
@Slf4j
public class AdminUserController {

    private final AdminUserService adminUserService;

    @GetMapping("/")
    public ResponseEntity<?> getUsersList(){
        return ResponseEntity.status(HttpStatus.OK).body(adminUserService.getUsersList());
    }

    @PutMapping("/alter/{userSeq}")
    public ResponseEntity<?> alterUserDetail(@PathVariable Long userSeq,@RequestBody UserDetailDTO userDetailDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(adminUserService.alterUserDetail(userSeq,userDetailDTO));
    }

    @GetMapping("/profile")
    public ResponseEntity<?> getProfileList(){
        return ResponseEntity.status(HttpStatus.OK).body(adminUserService.getProfileList());
    }

    @GetMapping("/profile/detail")
    public ResponseEntity<?> getProfileDetail(){
        return ResponseEntity.status(HttpStatus.OK).body(adminUserService.getProfileDetail());
    }

    @PutMapping("/profile")
    public ResponseEntity<?> alterProfileState(@RequestBody UserProfileDTO userProfileDTO){
        return ResponseEntity.status(HttpStatus.OK).body(adminUserService.alterProfileState(userProfileDTO));
    }

    @PutMapping("/profile/detail")
    public ResponseEntity<?> alterProfileDetailState(@RequestBody UserProfileDetailDTO userProfileDetailDTO){
        return ResponseEntity.status(HttpStatus.OK).body(adminUserService.alterProfileDetail(userProfileDetailDTO));
    }
}