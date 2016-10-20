package net.castroebarros.babbage;

import static spark.Spark.get;

public class Server {
	public static void main(String[] args) {
		get("/", (req, res) -> "Welcome to Babbage!");
		get("/:handler", (req, res) -> {
			String handler = req.params(":handler");
			String command = req.queryParams("command");
			return Babbage.getInstance().print(handler, command);
		});
	}
}
