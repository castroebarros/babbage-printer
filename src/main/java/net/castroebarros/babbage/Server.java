package net.castroebarros.babbage;

import static spark.Spark.get;

public class Server {
	public static void main(String[] args) {
		get("/", (req, res) -> "Welcome to Babbage!");
	}
}
