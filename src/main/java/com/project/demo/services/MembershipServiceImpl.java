package com.project.demo.services;

import com.project.demo.entities.Membership;
import com.project.demo.repositories.MembershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MembershipServiceImpl implements MembershipService {
    @Autowired
    MembershipRepository membershipRepo;

    @Override
    public Membership createMembership(Membership m){
        Membership membership = membershipRepo.save(m);
        return membership;
    }

    @Override
    public Membership changeMembershipClass(Membership u, int id){
        Membership membership = membershipRepo.findById(id).get();
        membership.setMembership_class(u.getMembership_class());
        membershipRepo.save(membership);
        return membership;
    }

    @Override
    public void deleteMembership(int id){
        membershipRepo.deleteById(id);
    }

}
