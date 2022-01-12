package testSimu;

import java.time.LocalDate;
import java.util.Scanner;

class Dynamique {
	double vitesse;
	double direction; // direction en degré par rapport au nord

	public Dynamique(double v, double d) {
		this.vitesse = v;
		this.direction = d;
	}
}

class Message {
	Position position = new Position();
	Dynamique dynamique;
	LocalDate dateTime = LocalDate.now();
	LocalDate expiration = LocalDate.now();
	String urgenceType;
	String mesureDecide;

	public Message(Dynamique dynamique, String urgenceType, String mesureDecide) {
		this.urgenceType = urgenceType;
		this.mesureDecide = mesureDecide;
		this.dynamique = dynamique;
	}
}

class Position {
	double latitude = 1.0;
	double longitude = 2.0;
	double altitude = 3.0;
}

public class Csc {

	Dynamique dynamique;
	Position position;
	double intensiteFrein = 0.5;
	double distanceObstacle;
	Message msgToSend;

	public Csc() {
	}

	public Csc(double vitesse, double direction, double distanceObstacle) {
		this.dynamique = new Dynamique(vitesse, direction);
		this.position = new Position();
		this.distanceObstacle = distanceObstacle;
	}

	public double distanceSecurite(double vitesse) {
		return (vitesse / 10.0) * 6.0;
	}

	/**
	 * renvoie true si obstacle < distance de sécurité
	 */
	boolean cscIsDanger(double vitesse, double distanceObstacle) {
		return (distanceObstacle < distanceSecurite(vitesse));
	}

	double cscDecision(boolean danger) {
		if (danger) {
			return intensiteFrein;
		} else {
			return 0.0;
		}
	}

	Message cscSendMessage() {
		Message messageToSend = new Message(dynamique, "urgence", "freinage");
		this.msgToSend = messageToSend;
		return messageToSend;
	}

	public static void main(String[] args) {
		System.out.println("*** test et simulation ***");

		double vitesse;
		double direction;
		double frein;
		double distanceObstacle;

		while (true) {
			Scanner input = new Scanner(System.in);

			// collecte données
			System.out.println("Entrez la vitesse de la voiture (double)");
			vitesse = input.nextDouble();

			System.out.print("Entrez la direction (double) ");
			direction = input.nextDouble();

			System.out.print("Entrez intensité frein (double) ");
			distanceObstacle = input.nextDouble();

			Csc csc = new Csc(vitesse, direction, distanceObstacle);

			boolean isDanger = csc.cscIsDanger(csc.dynamique.vitesse, csc.distanceObstacle); // détermination du danger
																								// double freinage =
			csc.cscDecision(isDanger); // décision if (isDanger) { csc.msgToSend =
			csc.cscSendMessage(); // envoie de messages
			input.close();
		}
	}
}
