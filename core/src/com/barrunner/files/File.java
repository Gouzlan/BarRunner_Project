package com.barrunner.files;

import java.io.InputStream;

public interface File {
	public boolean exists(String filename);
	public InputStream read(String filename);
}
