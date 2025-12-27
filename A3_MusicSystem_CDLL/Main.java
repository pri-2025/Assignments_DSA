package A3_MusicSystem_CDLL;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Playlist playlist = new Playlist();
		Scanner sc = new Scanner(System.in);
		int choice;

		do {
			System.out.println("------- Music Player Menu --------");
			System.out.println("1. Add Song");
			System.out.println("2. Play Next Song");
			System.out.println("3. Play Previous Song");
			System.out.println("4. Show Current Song");
			System.out.println("5. Delete Song by ID");
			System.out.println("6. Show Playlist (First to Last)");
			System.out.println("7. Show Playlist (Last to First)");
			System.out.println("8. Exit");
			System.out.println();
			System.out.print("Enter your choice: ");
			choice = sc.nextInt();
			System.out.println();
			switch (choice) {
			case 1:
				playlist.addSong();
				System.out.println();
				break;
			case 2:
				playlist.playNext();
				System.out.println();
				break;
			case 3:
				playlist.playPrevious();
				System.out.println();
				break;
			case 4:
				playlist.displayCurrent();
				System.out.println();
				break;
			case 5:
				playlist.deleteSong();
				System.out.println();
				break;
			case 6:
				playlist.showPlaylist();
				System.out.println();
				break;
			case 7:
				playlist.showPlaylistReverse();
				System.out.println();
				break;
			case 8:
				System.out.println("Exiting Music Player...");
				System.out.println();
				break;
			default:
				System.out.println("Invalid choice. Try again.");
				System.out.println();
			}
		} while (choice != 8);
	}
}
