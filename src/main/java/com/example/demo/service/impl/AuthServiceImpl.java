
// package com.example.demo.service.impl;

// import com.example.demo.dto.AuthRequest;
// import com.example.demo.dto.AuthResponse;
// import com.example.demo.exception.BadRequestException;
// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.model.UserAccount;
// import com.example.demo.repository.UserAccountRepository;
// import com.example.demo.service.AuthService;
// import org.springframework.stereotype.Service;

// @Service
// public class AuthServiceImpl implements AuthService {

//     private final UserAccountRepository userRepo;

//     public AuthServiceImpl(UserAccountRepository userRepo) {
//         this.userRepo = userRepo;
//     }

//     @Override
//     public UserAccount register(UserAccount userAccount) {

//         // Store password as-is (NO hashing)
//         return userRepo.save(userAccount);
//     }

//     @Override
//     public AuthResponse authenticate(AuthRequest request) {

//         UserAccount user = userRepo.findByEmail(request.getEmail())
//                 .orElseThrow(() -> new ResourceNotFoundException("User not found"));

//         // Plain-text password comparison
//         if (!request.getPassword().equals(user.getPassword())) {
//             throw new BadRequestException("Invalid credentials");
//         }

//         AuthResponse response = new AuthResponse();
//         response.setToken("dummy-token"); // No JWT
//         response.setUserId(user.getId());
//         response.setEmail(user.getEmail());
//         response.setRole(user.getRole());

//         return response;
//     }
// }