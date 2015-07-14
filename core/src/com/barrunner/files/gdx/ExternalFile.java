package com.barrunner.files.gdx;

import java.io.InputStream;

import com.badlogic.gdx.Gdx;
import com.barrunner.files.File;

public class ExternalFile implements File {

	@Override
	public boolean exists(String filename) {
		return Gdx.files.external(filename).exists();
	}

	@Override
	public InputStream read(String filename) {
		return Gdx.files.external(filename).read();
	}
}
