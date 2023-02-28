package com.example.controller;


import com.example.dto.AttachDTO;
import com.example.enums.ProfileRole;
import com.example.service.AttachService;
import com.example.util.JwtTokenUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/attach")
public class AttachController {
    @Autowired
    private AttachService attachService;

    @PostMapping("/upload")
    public ResponseEntity<AttachDTO> upload(@RequestParam("file") MultipartFile file) {//ishlaydi test buldi
        AttachDTO dto = attachService.createAttach(file);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping(value = "/open/{id}", produces = MediaType.IMAGE_PNG_VALUE)//ishlaydi test buldi
    public ResponseEntity<byte[]> open(@PathVariable String id) {
        if (id != null && id.length() > 0) {
            return ResponseEntity.ok(this.attachService.loadImage(id));
        }
        return null;
    }

    @DeleteMapping("/delete/{id}")//ishlaydi test buldi
    public ResponseEntity<?> deleteById(
            @PathVariable String id) {
        Boolean response = attachService.delete(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/open/{fileName}", produces = MediaType.ALL_VALUE)//ishlaydi test buldi
    public byte[] openGeneral(@PathVariable String fileName) {
        byte[] response = attachService.openGeneral(fileName);
        return response;
    }

    @GetMapping(value = "/download/{fileName}", produces = MediaType.ALL_VALUE)//ishlaydi test buldi
    public ResponseEntity<?> download(@PathVariable String fileName) {
        Resource response = attachService.download(fileName);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/pagination")
    public ResponseEntity<?> getList(HttpServletRequest request,
                                     @RequestParam Integer page,
                                     @RequestParam Integer size) {
        JwtTokenUtil.getIdFromHeader(request, ProfileRole.ROLE_ADMIN);

        Page<AttachDTO> response = attachService.getList(page, size);
        return ResponseEntity.ok(response);

    }

}
