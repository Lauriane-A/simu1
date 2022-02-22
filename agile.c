#include <stdio.h>
#include <stdlib.h>

#define DEFAULT_DIGITS 4
#define DEFAULT_MAX_ATTEMPTS 10
#define DEFAULT_MAX_RANGE 6 //0-5

typedef struct game_set_s {

	int digits;
	int max_attempts;
	int current_attempts;
	int *number;

} game_set;

game_set game;

void init_game (int digits, int max_attempts) {

	game.digits = digits;
	game.max_attempts = max_attempts;
	game.current_attempts = 0;
	game.number = (int*)malloc(sizeof(int)*digits);

}

void free_game () {
	free(game.number);
}

void display_settings() {
	printf("Number of digits: %d\nMax attempts: %d\n", game.digits, game.max_attempts);
}

void number_generator () {

	srand((unsigned)(time(NULL)));
	for (int i = 0; i  < game.digits; i++) {
		game.number[i] = rand() % DEFAULT_MAX_RANGE;
	}
}

void display_number () {
	printf("secret number: ");
	for(int i= 0; i < game.digits; i++) {
		printf("%d ", game.number[i]);
	}
	printf("\n");
}

int main(int argc, char const *argv[]) {

    printf("* * * Master Mind * * *\n");
	init_game(DEFAULT_DIGITS, DEFAULT_MAX_ATTEMPTS);
	number_generator();
	display_settings();
	display_number();
	free_game();
    return 0;
}
