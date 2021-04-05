package com.example.demo.Repoitory;

import com.example.demo.Model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContactRepository implements ICRUD<Contact> {

    @Autowired
    JdbcTemplate template;

    @Override
    public void create(Contact contact) {
        String sqlStr = "INSERT INTO kontakt (fornavn, efternavn, adresse, husNr, tlfnumb) VALUES (?, ?, ?, ?, ?)";
        template.update(sqlStr, contact.getFornavn(), contact.getEfternavn(), contact.getAdresse(), contact.getHusNr(), contact.getTlfnumb());
    }

    @Override
    public List<Contact> readAll() {
        String sqlStr = "SELECT * from kontakt";
        RowMapper<Contact> rowMapper = new BeanPropertyRowMapper<>(Contact.class);
        return template.query(sqlStr, rowMapper);
    }

    @Override
    public Contact getContact(long id) {
        String sqlStr = "SELECT * FROM kontakt WHERE kontaktID=?";
        RowMapper<Contact> rowMapper = new BeanPropertyRowMapper<>(Contact.class);
        return template.queryForObject(sqlStr, rowMapper, id);
    }

    @Override
    public void update(Contact contact) {
        String sqlStr = "UPDATE kontakt SET fornavn=?, efternavn=?, adresse=?, husNr=?, tlfnumb=? WHERE kontaktID=?";
        template.update(sqlStr, contact.getFornavn(), contact.getEfternavn(), contact.getAdresse(), contact.getHusNr(), contact.getTlfnumb(), contact.getKontaktID());
    }

    @Override
    public void delete(long id) {
        String sql = "DELETE FROM kontakt WHERE kontaktID = ?";
        template.update(sql, id);
    }
}
