package com.example.repository;

import com.example.dto.EmployeeFilterDto;
import com.example.dto.profile.ProfileFilterDTO;
import com.example.entity.Employee;
import com.example.entity.Profile;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EmployeeCustomRepository {

    @Autowired
    private EntityManager entityManager;

    public List<Employee> filter(EmployeeFilterDto employee, int page, int size) {
        StringBuilder builder = new StringBuilder("SELECT a FROM Employee a ");
        Map<String,Object> params = new HashMap();

        if (employee.getName() != null) {
            builder.append(" And a.name =:name ");
            params.put("name",employee.getName());
        }
        if (employee.getSurname()!=null){
            builder.append( " and a.surname =:surname ");
            params.put("surname",employee.getSurname());
        }
        if (employee.getEmail()!=null){
            builder.append( " and a.email =:email ");
            params.put("email", employee.getEmail());
        }
        if (employee.getRoomForWork()!=null){
            builder.append( " and a.room_for_work =:room_for_work ");
            params.put("room_for_work", employee.getRoomForWork());
        }
        if (employee.getNumber()!=null){
            builder.append( " and a.number =:number ");
            params.put("number", employee.getNumber());
        }
        Query query = entityManager.createQuery(builder.toString());


        query.setFirstResult((page - 1) * size);
        query.setMaxResults(size);
        for (Map.Entry<String,Object> entry: params.entrySet()){
            query.setParameter(entry.getKey(),entry.getValue());
        }
        List<Employee> employeeEntityList = query.getResultList();
        return employeeEntityList;

    }
    public List<Profile> getAll() {
        Query query = this.entityManager.createQuery("SELECT p From Profile as p");
        List profileEntities = query.getResultList();
        return profileEntities;
    }



    public List<Profile> getAllNative() {
        Query query = entityManager.createNativeQuery("SELECT * FROM profile ", Profile.class);
        List profileEntities = query.getResultList();
        return profileEntities;
    }
}
