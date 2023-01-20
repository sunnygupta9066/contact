package com.gl.mycontacts.service;

import com.gl.mycontacts.model.Contact;
import com.gl.mycontacts.util.Trie;

import java.util.List;
import java.util.stream.Collectors;

public class AddressBook {

    private Trie<Contact> contactTrie;

    public AddressBook() {
        contactTrie = new Trie<>();
    }

    public void addContact(Contact contact) {
        List<Contact> contacts = contactTrie.look(contact.getName());
        if(!contacts.isEmpty()){
            throw new RuntimeException();
        }
        contactTrie.insert(contact.getName(), contact);
    }

    public void deleteContact(String name) {
        List<Contact> contacts = contactTrie.look(name);
        if(contacts.isEmpty()){
            throw new RuntimeException();
        }
        contactTrie.delete(name, contacts.get(0));
    }

    public void updateContact(String name, Contact contact) {
        deleteContact(name);
            contactTrie.insert(contact.getName(), contact);
    }

    public List<Contact> searchByName(String name) {
        List<Contact> contacts = contactTrie.search(name);
        if(contacts.isEmpty()){
            throw new RuntimeException();
        }
        return contacts;
    }

    public List<Contact> searchByOrganisation(String organisation) {
        List<Contact> contacts = contactTrie.search("");
        if(organisation.isBlank()){
            return contacts;
        }
        List<Contact> organisations = contacts.stream().filter(c -> c.getOrganisation().toLowerCase().contains(organisation.toLowerCase())).collect(Collectors.toList());
        return organisations;
    }

}