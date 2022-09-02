package com.project.demo.services;

import com.project.demo.entities.Membership;

import java.util.List;

public interface MembershipService {

    Membership createMembership(Membership membership);

    Membership changeMembershipClass(Membership membership, int id);

    void deleteMembership(int id);
}
