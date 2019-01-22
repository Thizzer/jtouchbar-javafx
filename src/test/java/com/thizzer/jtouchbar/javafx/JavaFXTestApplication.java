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

import static org.junit.Assert.assertNotNull;

import com.thizzer.jtouchbar.JTouchBar;
import com.thizzer.jtouchbar.item.TouchBarItem;
import com.thizzer.jtouchbar.item.view.TouchBarButton;

import javafx.application.*;
import javafx.stage.*;

import javafx.scene.*;
import javafx.scene.layout.*;

@SuppressWarnings("restriction")
public class JavaFXTestApplication extends Application {
			
	public static JTouchBar constructTouchBar() {
		JTouchBar jTouchBar = new JTouchBar();
        jTouchBar.setCustomizationIdentifier(JavaFXTestApplication.class.getName());
        
		// flexible space
		jTouchBar.getItems().add( new TouchBarItem( TouchBarItem.NSTouchBarItemIdentifierFlexibleSpace ) );
		
		// button
		TouchBarItem touchBarButtonItem = new TouchBarItem("T1");
		touchBarButtonItem.setCustomizationAllowed(true);
		
		TouchBarButton touchBarButton = new TouchBarButton();
		touchBarButton.setTitle("Button");
		touchBarButtonItem.setView(touchBarButton);
        
		jTouchBar.getItems().add( touchBarButtonItem );
		
        return jTouchBar;
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		JTouchBar jTouchBar = constructTouchBar();
		assertNotNull(jTouchBar);
				
		primaryStage.setTitle("JavaFX JTouchBar Test");
        
        StackPane root = new StackPane();
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
        
        JTouchBarJavaFX.show(jTouchBar, primaryStage);
	}
}
