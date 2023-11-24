package pharmacy.service.Impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pharmacy.model.Worker;
import pharmacy.repo.WorkerRepo;
import pharmacy.service.WorkerService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class WorkerServiceImpl implements WorkerService {
    @Autowired
    private final WorkerRepo workerRepo;
    @Override
    public void save(Worker worker) {
        workerRepo.save(worker);
    }

    @Override
    public void update(Long id, Worker worker) {
        Worker worker1 = workerRepo.findById(id).orElseThrow(()-> new NoSuchElementException("Worker not found by id"+id));
        worker1.setName(worker.getName());
        worker1.setEmail(worker.getEmail());
        worker1.setAddress(worker.getAddress());
        worker1.setDateOfBirth(worker.getDateOfBirth());
        worker1.setSalary(worker.getSalary());
        worker1.setPharmacy(worker.getPharmacy());
        workerRepo.save(worker1);
    }

    @Override
    public void delete(Long id) {
        workerRepo.deleteById(id);
    }

    @Override
    public Worker findById(Long id) {
        return workerRepo.findById(id).orElseThrow(()->new NoSuchElementException("Worker not found by id"+id));
    }

    @Override
    public List<Worker> getAllSalaryBySortAsc() {
        return workerRepo.getAllSalaryBySortAsc();
    }

    @Override
    public List<Worker> getAllSalaryBySortDesc() {
        return workerRepo.getAllSalaryBySortDesc();
    }

    @Override
    public List<Worker> getAllWorkersByPharmacyId(long pharmacyId) {
        return workerRepo.getAllWorkersByPharmacyId(pharmacyId);
    }
}
