package com.example.demo.ServiceInterface;

import com.example.demo.Entity.Address;

import java.util.List;

public interface AddressService {
    List<Address> getAllAddress();
    Address getAddressById(String id);
    Address addAddress(Address address);
    Address updateAddress(Address address);
    String deleteAddress(String id);

}
