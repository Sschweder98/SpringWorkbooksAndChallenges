package com.ltp.contacts.service;

import java.util.List;

import com.ltp.contacts.exception.ContactNotFoundException;
import com.ltp.contacts.pojo.Contact;

public interface ContactService {
    Contact getContactById(String id) throws ContactNotFoundException;
    void saveContact(Contact contact);
    void updateContact(String id, Contact contact) throws ContactNotFoundException;
    void deleteContact(String id) throws ContactNotFoundException;
    List<Contact> getContacts();
}
