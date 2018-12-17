/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
module biapj.h {
    requires h2;
    requires biapj.integration;
    requires biapj.model;
    requires java.sql;
    requires biapj.util;
    provides biapj.integration.ReaderDAO with biapj.h2.impl.H2ReaderDAOImpl;
}
