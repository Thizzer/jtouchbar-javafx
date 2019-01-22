/**
 * JTouchBar
 *
 * Copyright (c) 2018 - 2019 thizzer.com
 *
 * This software may be modified and distributed under the terms
 * of the MIT license.  See the LICENSE file for details.
 *
 * @author  	M. ten Veldhuis
 */
package com.thizzer.jtouchbar.javafx;

import static org.junit.Assert.assertTrue;

import org.junit.Ignore;

import javafx.application.*;
import javafx.stage.*;
import javafx.embed.swing.JFXPanel;

import org.junit.Test;

public class JavaFXTest {

	@Ignore
	@Test
	public void test() {
		// Initializes the JavaFx Platform
        new JFXPanel();
        
        Platform.runLater(new Runnable() {

            @Override
            public void run() {
            		try {
            			new JavaFXTestApplication().start(new Stage());
            		} 
                catch (Exception ignored) {
                		assertTrue(false);
                }
            }
        });
		
        try {
			Thread.sleep(1000);
		} 
        catch (InterruptedException ignored) {
        		assertTrue(false);
        }
	}

}
