package com.barrunner.files.gdx;

import java.io.InputStream;

import com.badlogic.gdx.Gdx;
import com.barrunner.files.File;

public class LocalFile implements File {

	@Override
	public boolean exists(String filename) {
		return Gdx.files.local(filename).exists();
	}

	@Override
	public InputStream read(String filename) {
		return Gdx.files.local(filename).read();
	}
}