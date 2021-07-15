package uz.developer.appexpertserver1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.developer.appexpertserver1.entity.Payment;
import uz.developer.appexpertserver1.payload.ApiResponse;
import uz.developer.appexpertserver1.payload.ReqPayment;
import uz.developer.appexpertserver1.repository.PaymentRepository;
import uz.developer.appexpertserver1.service.PaymentService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    PaymentRepository paymentRepository;
    @Autowired
    PaymentService paymentService;


    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addPayment(@RequestBody ReqPayment reqPayment){
        ApiResponse response = paymentService.addPayment(reqPayment);
        return ResponseEntity.status(response.isSuccess()?HttpStatus.OK:HttpStatus.CONFLICT).body(response);
    }

    @GetMapping("/list")
    public List<Payment> listPayment(){
        return paymentService.getAllPayment();
    }

    @GetMapping("/get/{id}")
    public Payment getPayment(@PathVariable UUID id){
        return paymentService.getPayment(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deletePayment(@PathVariable UUID id){
        ApiResponse response = paymentService.deletePayment(id);
        return ResponseEntity.status(response.isSuccess()?HttpStatus.OK:HttpStatus.CONFLICT).body(response);
    }
}
