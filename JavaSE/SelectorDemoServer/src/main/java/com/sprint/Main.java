package com.sprint;

import java.io.IOException;
import com.sprint.service.*;
public class Main {
	public static void main(String[] args) throws IOException {
		ServerService ss = new ServerService(19999);
		new Thread(ss).start();
	}
}
