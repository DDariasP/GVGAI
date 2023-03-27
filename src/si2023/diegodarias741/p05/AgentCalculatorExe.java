package si2023.diegodarias741.p05;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import tools.Utils;
import tracks.ArcadeMachine;

public class AgentCalculatorExe {

	public static void main(String[] args) {

		String p0 = "si2023.diegodarias741.p05.AgentCalculatorDecisionTree";

		//Load available games
		String spGamesCollection = "examples/all_games_sp.csv";
		String[][] games = Utils.readGames(spGamesCollection);

		//Game settings
		boolean visuals = false;
		Random r = new Random(System.currentTimeMillis());
		int seed;

		// Game and level to play
		int gameIdx = 89;
		int levelIdx = 4; // level names from 0 to 4 (game_lvlN.txt).

		String gameName = games[gameIdx][1];
		String game = games[gameIdx][0];
		String level1 = game.replace(gameName, gameName + "_lvl" + levelIdx);

		for (int i = 0; i < 1000; i++) {
			// 2. This plays a game in a level by the agent
			seed = r.nextInt();
			double[] results = ArcadeMachine.runOneGame(game, level1, visuals, p0, null, seed, 0);

			System.out.println(i);

			write(results, "v3-6.txt");
		}
		
		System.out.println("\nDone.");

		System.exit(0);
	}

	public static void write(double[] results, String name) {

		String win, score, ticks, line;

		try {

			File file = new File(name);
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter writer = new FileWriter(name, true);

			win = String.valueOf(results[0]);
			score = String.valueOf(results[1]);
			ticks = String.valueOf(results[2]);

			score = String.format("%7s", score);
			ticks = String.format("%6s", ticks);

			line = win + " " + score + " " + ticks + "\n";

			writer.write(line);

			writer.close();

		} catch (IOException e) {
		}

	}

}