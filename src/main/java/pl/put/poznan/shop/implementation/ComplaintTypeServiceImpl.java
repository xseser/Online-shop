package pl.put.poznan.shop.implementation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.put.poznan.shop.entity.Complaint;
import pl.put.poznan.shop.entity.ComplaintType;
import pl.put.poznan.shop.repository.ComplaintTypeRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class ComplaintTypeServiceImpl {

    private final ComplaintTypeRepository complaintTypeRepository;

    public List<ComplaintType> findAllComplaintTypes(){
        return complaintTypeRepository.findAll();
    }
}
