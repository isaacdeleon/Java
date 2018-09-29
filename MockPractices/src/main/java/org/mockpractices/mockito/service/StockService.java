/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mockpractices.mockito.service;

import org.mockpractices.mockito.dto.Stock;

/**
 *
 * @author aco-ec-024
 */
public interface StockService {
    public double getPrice(Stock stock);
}
