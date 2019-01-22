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

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import com.thizzer.jtouchbar.JTouchBar;
import com.thizzer.jtouchbar.JTouchBarJNI;

import javafx.stage.Window;

public class JTouchBarJavaFX {
		
	static {
		try {
			System.loadLibrary("JTouchBarJavaFX");
		}
		catch(UnsatisfiedLinkError e) {	
			loadLibraryFromJar("/lib/libJTouchBarJavaFX.dylib");
		}
	}
	
	public static void show(JTouchBar jTouchbar, Window window) {
		long viewPointer = getViewPointer(window);
		JTouchBarJNI.setTouchBar0(viewPointer, jTouchbar);
	}
	
	public static void hide(Window window) {
		if(window == null) {
			return;
		}
		long viewPointer = getViewPointer(window);
		JTouchBarJNI.setTouchBar0(viewPointer, null);
	}
	
	private static long getViewPointer(Window window) throws RuntimeException {
		if(window == null) {
			return 0;
		}
		
		try {
	        return getJavaFXViewPointer0(window);
		} 
	    catch (Exception exception) {
	    	throw new RuntimeException(exception);
	    }
	}
	
	static native long getJavaFXViewPointer0(Window w);
	
	private static void loadLibraryFromJar(String path) throws UnsatisfiedLinkError {
		try (InputStream inputStream = JTouchBarJNI.class.getResourceAsStream(path)) {
			File tempLib = File.createTempFile(path, "");
			
		    byte[] buffer = new byte[1024];
		    int read = -1;
		    
		    try(FileOutputStream fileOutputStream = new FileOutputStream(tempLib)) {
			    	while((read = inputStream.read(buffer)) != -1) {
			    		fileOutputStream.write(buffer, 0, read);
			    	}
		    }
		    
		    System.load(tempLib.getAbsolutePath());
		}
		catch(Exception e) {
			throw new UnsatisfiedLinkError("Unable to open "+ path +" from jar file.");
		}
	}
}
