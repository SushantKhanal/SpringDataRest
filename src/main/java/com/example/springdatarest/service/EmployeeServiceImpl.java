package com.example.restcrud.service;
import com.example.restcrud.dao.EmployeeDAO;
import com.example.restcrud.dao.EmployeeRepository;
import com.example.restcrud.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
//    private EmployeeDAO employeeDAO;
    private EmployeeRepository employeeRepository;

//    @Autowired
//    public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO) {
//        employeeDAO = theEmployeeDAO;
//    }
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
            employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
//            return employeeDAO.findAll();
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
//        return employeeDAO.findById(theId);
        Optional<Employee> result = employeeRepository.findById(theId);
        Employee theEmployee = null;
        if(result.isPresent()) {
            theEmployee = result.get();
        } else {
            throw new RuntimeException("Did not find employee id - " + theId);
        }
        return theEmployee;
    }

    @Override
//    @Transactional //SpringDataJPA provides Transactional functionality out of the box
    public Employee save(Employee employee) {
//        return employeeDAO.save(employee);
        return employeeRepository.save(employee);
    }

    @Override
//    @Transactional //SpringDataJPA provides Transactional functionality out of the box
    public void deleteById(int theId) {
//        employeeDAO.deleteById(theId);
        employeeRepository.deleteById(theId);
    }
}
