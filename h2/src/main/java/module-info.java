/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
module accounts.h {
    requires h2;
    requires accounts.integration;
    requires accounts.model;
    requires java.sql;
    requires accounts.util;
    provides accounts.integration.ReaderDAO with accounts.h2.impl.H2ReaderDAOImpl;
}
