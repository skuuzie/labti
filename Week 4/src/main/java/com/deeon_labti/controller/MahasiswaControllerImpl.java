/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.deeon_labti.controller;

import com.deeon_labti.model.ModelMahasiswa;
import java.util.List;
import org.hibernate.*;
import org.hibernate.query.Query;
import com.deeon_labti.model.HibernateUtil;

/**
 *
 * @author hyun
 */
public class MahasiswaControllerImpl implements MahasiswaController {

    @Override
    public void addMhs(ModelMahasiswa mhs) {
        Transaction trx = null;
        
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            trx = session.beginTransaction();
            session.save(mhs);
            trx.commit();
        } catch (Exception e) {
            if (trx != null) {
                trx.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public ModelMahasiswa getMhs(int id) {
           throw new UnsupportedOperationException("TODO");
    }

    @Override
    public void updateMhs(ModelMahasiswa mhs) {
        Transaction trx = null;
        
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            trx = session.beginTransaction();
            session.update(mhs);
            trx.commit();
        } catch (Exception e) {
            if (trx != null) {
                trx.rollback();
            }
            e.printStackTrace();
        }    
    }

    @Override
    public void deleteMhs(int id) {
        Transaction trx = null;
        
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            trx = session.beginTransaction();
            session.delete(session.get(ModelMahasiswa.class, id));
            trx.commit();
        } catch (Exception e) {
            if (trx != null) {
                trx.rollback();
            }
            e.printStackTrace();
        }    }

    @Override
    public List<ModelMahasiswa> getAllMahasiswa() {
        Transaction trx = null;
        List<ModelMahasiswa> listMhs = null;
        
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<ModelMahasiswa> query = session.createQuery("from ModelMahasiswa", ModelMahasiswa.class);
            listMhs = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }    
        return listMhs;
    }
}
