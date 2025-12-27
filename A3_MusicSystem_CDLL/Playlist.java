package A3_MusicSystem_CDLL;

import java.util.Scanner;

import A2_CodeClubSubscription_LL.Member;

public class Playlist {

	Song head = null;
	Song tail = null;
	Song curr = null;

	Scanner sc = new Scanner(System.in);

	public void addSong() {
		// TODO Auto-generated method stub

		char ans;

		do {
			sc.nextLine();
			System.out.print("Enter name of the song : ");
			String s_name = sc.nextLine();
			System.out.print("Enter ID of the song : ");
			int s_id = sc.nextInt();
			sc.nextLine();
			System.out.print("Enter name of artist of the song : ");
			String a_name = sc.nextLine();

			Song S = new Song(s_name, s_id, a_name);

			if (head == null) {
				head = tail = curr = S;
			}
			S.prev = tail;
			S.next = head;
			tail.next = S;
			head.prev = S;
			tail = S;

			System.out.println("\nSong added successfully!\n");
			System.out.println();

			System.out.print("Do you want to add another member? (Y/N): ");
			ans = sc.next().charAt(0);
			System.out.println();

		} while (ans == 'Y' || ans == 'y');
	}

	public void playNext() {
		// TODO Auto-generated method stub
		curr = curr.next;
		displayCurrent();
	}

	public void playPrevious() {
		// TODO Auto-generated method stub
		curr = curr.prev;
		displayCurrent();
	}

	public void displayCurrent() {
		// TODO Auto-generated method stub
		if (curr != null) {
			System.out.println("Name of the song : " + curr.s_name);
			System.out.println("ID of the song : " + curr.id);
			System.out.println("Name of the artist : " + curr.a_name);
			System.out.println();
		}

	}

	public void deleteSong() {
		// TODO Auto-generated method stub
		if (head == null) {
			System.out.println("Playlist is empty.");
			return;
		}
		System.out.print("Enter ID of the song to delete: ");
		int id = sc.nextInt();

		Song temp = head;

		do {
			if (temp.id == id)
				break;
			temp = temp.next;
		} while (temp != head);
		if (temp.id != id) {
			System.out.println("Song not found.");
			return;
		}
		if (temp == head && temp == tail) {
			head = tail = curr = null;
		} else {
			temp.prev.next = temp.next;
			temp.next.prev = temp.prev;

			if (temp == head)
				head = temp.next;
			if (temp == tail)
				tail = temp.prev;
			if (temp == curr)
				curr = temp.next;
		}
		System.out.println("Deleted song: " + temp.s_name);
	}

	public void showPlaylist() {
		// TODO Auto-generated method stub
		if (head == null) {
			System.out.println("Playlist is empty.");
			return;
		}
		Song temp = head;
		System.out.println("Playlist (First to Last):");
		do {
			System.out.println("[ID: " + temp.id + ", Name: " + temp.s_name + ", Artist: " + temp.a_name + "]");
			temp = temp.next;
		} while (temp != head);
	}

	public void showPlaylistReverse() {
		// TODO Auto-generated method stub
		if (tail == null) {
			System.out.println("Playlist is empty.");
			return;
		}
		Song temp = tail;
		System.out.println("Playlist (Last to First):");
		do {
			System.out.println("[ID: " + temp.id + ", Name: " + temp.s_name + ", Artist: " + temp.a_name + "]");
			temp = temp.prev;
		} while (temp != tail);
	}
}
