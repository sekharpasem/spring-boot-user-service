package com.centime.userservice.service;

import com.centime.userservice.entity.User;
import com.centime.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * save user
     * @param user
     * @return
     */
    public User saveUser(User user) {
        log.info("Inside saveUser of UserService");
        return userRepository.save(user);
    }

    /**
     * gets user
     * @param id
     * @return
     */
    public Optional<User> getUser(Long id) {
        log.info("Inside getUser of UserService");
        return userRepository.findById(id);
    }

    /**
     * gets all users with nested json
     * @return
     */
    public List<User> getAll() {
        log.info("Inside getAll of UserService");
        List<User> usersAll = userRepository.findAll();
        List subClasses = new ArrayList();
        LinkedHashSet visitedNames = new LinkedHashSet();
        for(User user:usersAll){
            HashMap aClassMap= findAllSubClasses(user.getId(), user.getName(), usersAll, visitedNames);
            if(aClassMap!=null){
                if(aClassMap.containsKey("Sub Classes")){
                    subClasses.add(aClassMap);
                }

            }
        }
        System.out.println(subClasses);
        return subClasses;
    }

    /***
     * find subclasses of user
     * @param id
     * @param name
     * @param usersAll
     * @param visitedNames
     * @return
     */
    public HashMap findAllSubClasses(Long id, String name, List<User> usersAll, LinkedHashSet visitedNames){
        HashMap sclass = new HashMap();
        sclass.put("Name", name);
        visitedNames.add(name);
        for(User user: usersAll){
            if(id.equals(user.getParentid())){
                if(!visitedNames.contains(user.getName())){
                    HashMap map = findAllSubClasses(user.getId(), user.getName(), usersAll, visitedNames);
                    if(sclass.containsKey("Sub Classes")){
                        List list = (List) sclass.get("Sub Classes");
                        list.add(map);
                        sclass.put("Sub Classes", list);
                    }else{
                        ArrayList list = new ArrayList();
                        list.add(map);
                        sclass.put("Sub Classes", list);
                    }
                }
            }
        }
        return sclass;
    }

}
