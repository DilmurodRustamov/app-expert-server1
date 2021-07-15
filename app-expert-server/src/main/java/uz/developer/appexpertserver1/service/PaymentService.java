package uz.developer.appexpertserver1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.developer.appexpertserver1.entity.PayType;
import uz.developer.appexpertserver1.entity.Payment;
import uz.developer.appexpertserver1.payload.ApiResponse;
import uz.developer.appexpertserver1.payload.ReqPayment;
import uz.developer.appexpertserver1.repository.PayTypeRepository;
import uz.developer.appexpertserver1.repository.PaymentRepository;
import uz.developer.appexpertserver1.repository.ProjectRepository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    PaymentRepository paymentRepository;
    @Autowired
    PayTypeRepository payTypeRepository;
    @Autowired
    ProjectRepository projectRepository;

    public ApiResponse addPayment(ReqPayment reqPayment) {

        Payment payment = new Payment(
                payTypeRepository.findById(reqPayment.getPayTypeId()).orElseThrow(() -> new ResourceNotFoundException("Pay type not found!")),
                projectRepository.findById(reqPayment.getProjectId()).orElseThrow(() -> new ResourceNotFoundException("Project not found!")),
                reqPayment.getAmount(),
                new Timestamp(new Date().getTime()));
        paymentRepository.save(payment);
        return new ApiResponse(true, "Added!");
    }

    public List<Payment> getAllPayment() {
        return paymentRepository.findAll();
    }

    public Payment getPayment(UUID id) {
        Optional<Payment> optionalPayment = paymentRepository.findById(id);
        return paymentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("payment not found!"));
    }

    public ApiResponse deletePayment(UUID id) {
        if (paymentRepository.existsById(id)) {
            paymentRepository.deleteById(id);
            return new ApiResponse(true, " payment deleted");
        }
        return new ApiResponse(false, " payment not found");
    }

    //TODO buni to'ldirishim kk
    public ApiResponse editPayment(UUID id, ReqPayment reqPayment){
        Payment payment = new Payment();
        if (paymentRepository.existsById(id)){
            payment.setAmount(reqPayment.getAmount());
            paymentRepository.save(payment);
            return new ApiResponse(true,"payment edited!");
        }

        return new ApiResponse(false,"payment not found!");
    }
}
