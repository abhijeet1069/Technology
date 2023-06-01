#include<iostream>

#define LOG(x) std::cout << x << std::endl;

//classes are like a new variable type.
//class variables are private by default
//struct are like classes, although they miss access specifier and inheritance features.
class Player{
    public:
        int x,y;
        int speed;
    
        void move(Player& player, int xa, int ya){
            player.x += xa * player.speed;
            player.y += ya * player.speed;
    }
};

int main(){
    Player player;
    player.x = 5;
    player.move(player,1,-1);
    std::cout<<player.x<<std::endl;
}