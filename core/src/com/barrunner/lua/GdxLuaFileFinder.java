package com.barrunner.lua;

import java.io.InputStream;

import org.luaj.vm2.lib.ResourceFinder;

import com.barrunner.files.*;
import com.barrunner.files.gdx.*;

public class GdxLuaFileFinder implements ResourceFinder {
	private File filePriorities[] = {new InternalFile(), 
									 new LocalFile(), 
									 new ExternalFile(), 
									 new AbsoluteFile()};
	
	@Override
	public InputStream findResource(String filename) {
		for (File file : filePriorities) {
			if(file.exists(filename)) {
				return file.read(filename);
			}
		}
		return null;
	}	
}
