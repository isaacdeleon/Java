/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mockpractices.test;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockpractices.mockito.service.StockService;
import org.mockpractices.mockito.dto.Portofolio;
import org.mockpractices.mockito.dto.Stock;

/**
 *
 * @author aco-ec-024
 */
public class PortofolioTest {
    
    private Portofolio portofolio;
    private StockService stockService;
    
    @Before
    public void setUp() {
        
        portofolio = new Portofolio();
        
        stockService = Mockito.mock(StockService.class);
        
        portofolio.setStockService(stockService);
    }
    
    @Test
    public void testMarketValue() {
        List<Stock> stocks = new ArrayList<Stock>();
        Stock googleStock = new Stock("1","Google",10);
        Stock microsoftSotck = new Stock("2", "Microsoft", 100);
        
        stocks.add(googleStock);
        stocks.add(microsoftSotck);
        
        portofolio.setStocks(stocks);
        
        Mockito.when(stockService.getPrice(googleStock)).thenReturn(50.00);
        Mockito.when(stockService.getPrice(microsoftSotck)).thenReturn(1000.00);
        
        double marketValue = portofolio.getMarketValue();
        Assertions.assertThat(marketValue).isEqualTo(100500.0);
    }
}
