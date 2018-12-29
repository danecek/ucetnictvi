/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
module accounts.integration {
    requires accounts.model;
    requires accounts.util;
    requires java.logging;
    exports accounts.integration;
    uses accounts.integration.ReaderDAO;
}
