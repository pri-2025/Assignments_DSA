package A3_MusicSystem_CDLL;

class Song {
	int id;
	String s_name;
	String a_name;
	Song prev, next;

	Song(String name, int id, String artist) {
		this.s_name = name;
		this.id = id;
		this.a_name = artist;
		this.prev = null;
		this.next = null;
	}
}