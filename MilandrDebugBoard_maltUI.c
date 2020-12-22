const char alphabet_EN[27][8] = { //LCD bit matrix
        {0x00,0x7c,0x12,0x12,0x12,0x12,0x7c,0x00}, //A 0
        {0x00,0x7e,0x4a,0x4a,0x4a,0x4a,0x34,0x00}, //B 1
        {0x00,0x3c,0x42,0x42,0x42,0x42,0x24,0x00}, //C 2
        {0x00,0x7e,0x42,0x42,0x42,0x42,0x3c,0x00}, //D 3
        {0x00,0x7e,0x4a,0x4a,0x4a,0x42,0x42,0x00}, //E 4
        {0x00,0x7e,0x0a,0x0a,0x0a,0x02,0x02,0x00}, //F 5
        {0x00,0x3c,0x42,0x42,0x52,0x52,0x30,0x00}, //G 6
        {0x00,0x7E,0x08,0x08,0x08,0x08,0x7E,0x00}, //H 7
        {0x00,0x00,0x42,0x7e,0x7e,0x42,0x00,0x00}, //I 8
        {0x00,0x30,0x40,0x40,0x40,0x40,0x3e,0x00}, //J 9
        {0x00,0x7e,0x08,0x08,0x08,0x14,0x62,0x00}, //K 10
        {0x00,0x7E,0x40,0x40,0x40,0x40,0x40,0x00}, //L 11
        {0x00,0x7e,0x04,0x08,0x08,0x04,0x7e,0x00}, //M 12
        {0x00,0x7e,0x04,0x08,0x10,0x20,0x7e,0x00}, //N 13
        {0x00,0x3C,0x42,0x42,0x42,0x42,0x3C,0x00}, //O 14
        {0x00,0x7e,0x0a,0x0a,0x0a,0x0a,0x04,0x00}, //P 15
        {0x00,0x3c,0x42,0x42,0x52,0x62,0x7c,0x00}, //Q 16
        {0x00,0x7E,0x0A,0x0A,0x1A,0x2A,0x44,0x00}, //R 17
        {0x00,0x44,0x4a,0x4a,0x4a,0x4a,0x32,0x00}, //S 18
        {0x00,0x02,0x02,0x7e,0x7e,0x02,0x02,0x00}, //T 19
        {0x00,0x3e,0x40,0x40,0x40,0x40,0x3e,0x00}, //U 20
        {0x00,0x1e,0x20,0x40,0x40,0x20,0x1e,0x00}, //V 21
        {0x00,0x3E,0x40,0x20,0x20,0x40,0x3E,0x00}, //W 22
        {0x00,0x42,0x24,0x18,0x18,0x24,0x42,0x00}, //X 23
        {0x00,0x06,0x08,0x70,0x70,0x08,0x06,0x00}, //Y 24
        {0x00,0x62,0x72,0x5a,0x4e,0x46,0x42,0x00}, //Z  25
        {0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00}  //blank space 26
};

const char arabic_Num[10][8] = {
        {0x00,0x7E,0x42,0x42,0x42,0x42,0x7E,0x00}, //0
        {0x00,0x00,0x42,0x7e,0x7e,0x40,0x00,0x00}, //1
        {0x00,0x7a,0x4a,0x4a,0x4a,0x4a,0x4e,0x00}, //2
        {0x00,0x4a,0x4a,0x4a,0x4a,0x4a,0x7e,0x00}, //3
        {0x00,0x0e,0x08,0x08,0x08,0x08,0x7e,0x00}, //4
        {0x00,0x4e,0x4a,0x4a,0x4a,0x4a,0x7a,0x00}, //5
        {0x00,0x7e,0x4a,0x4a,0x4a,0x4a,0x7a,0x00}, //6
        {0x00,0x02,0x02,0x02,0x02,0x02,0x7e,0x00}, //7
        {0x00,0x7e,0x4a,0x4a,0x4a,0x4a,0x7e,0x00}, //8
        {0x00,0x4e,0x4a,0x4a,0x4a,0x4a,0x7e,0x00} //9
};

const char lcdX[8] = {0xB8,0xB9,0xBA,0xBB,0xBC,0xBD,0xBE,0xBF};
const char lcdY[16] = {0x01,0x02,0x04,0x08,0x10,0x20,0x30,0x80,0xA0,0xA2,0x80,0x80,0x80,0x80,0x80,0x80};

void pause(int d){ // pause function ( d * 80 )
    d *= 80;
    while (d!=0){
        d--;
    }
}

void set_list(char num){ // function of set need list ( string )
    PORTE -> RXTX &= ~(1<<11); // set A0 - 0
    PORTC -> RXTX &= ~(1<<2); // set R/W - 0
    PORTC -> RXTX |= (1<<7); // set E-1 ( on  strobing)
    PORTA -> RXTX = num; // set data of string num ( DB7-DB0)
    pause(2); // pause
    PORTC -> RXTX &= ~(1<<7); // off strobing
    pause(2); // pause
}

void set_line(char num){ // function of set line
    PORTE -> RXTX &= ~(1<<11); // set A0-0
    PORTC -> RXTX &= ~(1<<2); // set R/W - 0
    PORTC -> RXTX |= (1<<7); // on strobing
    PORTA -> RXTX = num; // D7-D0
    pause(2); // pause
    PORTC -> RXTX &= ~(1<<7); // off strobing
    pause(2); // pause
}

void set_side(int side){
    //side = num;
    PORTC -> RXTX &= ~(1<<7); // set E - 0 ( off strobing )
    pause(2);
    if(side == 0){
        PORTE -> RXTX |= (1<<4); // E1 - 1
        PORTE -> RXTX &= ~(1<<5); // E2- 0
    }
    if(side == 1){
        PORTE -> RXTX |= (1<<5); // E2 - 1
        PORTE -> RXTX &= ~(1<<4); // E1- 0
    }
    pause(2); // pause
    PORTC -> RXTX |= (1<<7); // on strobing
    pause(2); // pause
}

void printOnScreen(int x, int y, int symNum){
    char symbol[8];
    int i = 0;
    if(symNum > 99){
        symNum = symNum-100;
        i = 0;
        while(i != 8){
            symbol[i] = arabic_Num[symNum][i];
            i++;
        }
    }else{
        i = 0;
        while(i != 8){
            symbol[i] = alphabet_EN[symNum][i];
            i++;
        }
    }

    if(y >= 8){

        set_side(1);
    }
    if(y < 8) {
        set_side(0);
    }

    set_list(lcdX[x]);
    set_line(lcdY[y]);

    i = 0;
    while(i!=8) {
        PORTE -> RXTX |= (1<<11);  // set A0 - 1
        PORTC -> RXTX &= ~(1<<2); // set R/W - 0
        PORTC -> RXTX |= (1<<7); // on strobbing E – 1
        PORTA -> RXTX = symbol[i]; // send value
        pause(2); // pause
        PORTC -> RXTX &= ~(1<<7); // off strobbing E – 0
        pause(2); // pause
        i++;
    }
}

void write_null(){ // address nulling
    int i=64; // êîë âî äåéñòâèÿ ñ÷åò÷èêà maybe it need
    while (i!=0) { // öèêë
        PORTE -> RXTX |= (1<<11); // set A0 - 1
        PORTC -> RXTX &= ~(1<<2); // set R/W - 0
        PORTC -> RXTX |= (1<<7); // strobbing on
        PORTA -> RXTX = 0x00; // null DB7-DB0
        pause(2); // pause
        PORTC -> RXTX &= ~(1<<7); // strobbing off
        pause(2); // pause
        i--; // decrement
    }
}

void clean(){ // ??????? ???????
set_list(0xB8); // ???? ?? ??????? set_list ???????? ?????? ?? b8 ?? bb
set_line(0x40); // ???? ?? ??????? set_line ???????? ?????? 40 (0100000)
write_null(); // ????? ??????? ?????????
set_list(0xB9);
set_line(0x40);
write_null();
set_list(0xBA);
set_line(0x40);
write_null();
set_list(0xBB);
set_line(0x40);
write_null();
set_list(0xBC);
set_line(0x40);
write_null();
set_list(0xBD);
set_line(0x40);
write_null();
set_list(0xBE);
set_line(0x40);
write_null();
set_list(0xBF);
set_line(0x40);
write_null();
}

void main (void) { // main

        RST_CLK ->PER_CLOCK = 0x02A00010; // clocking on (for port A, C, E?)
        // port À
        PORTA -> OE = 0x00ff; // data direction - to out
        PORTA -> FUNC = 0x0; // operating mode - port
        PORTA -> ANALOG = 0xffff; // analog operating mode - on
        PORTA -> PWR = 0xAAAAAAAA; // operating speed
        // port C
        PORTC -> OE = 0x0084; // data direction - to out
        PORTC -> FUNC = 0x0; // ðoperating mode - port
        PORTC -> ANALOG = 0xffff; // analog operating mode - on
        PORTC -> PWR = 0xAAAAAAAA; // ñêîðîñòü ðàáîòû ëèíèè ïîðòà
        // port E
        PORTE -> OE = 0xc30; // data direction - to out
        PORTE -> FUNC = 0x0; // operating mode - port
        PORTE -> ANALOG = 0xffff; // analog operating mode - on
        PORTE -> PWR = 0xAAAAAAAA; // operating speed

        //---- display settings
        PORTC -> RXTX &= ~(1<<7); // strobbing off
        PORTE -> RXTX |= (1<<4)|(1<<5); // set E1 and E2 - 1
        PORTE -> RXTX &= ~(1<<10); // RES = 0
        pause(2); // pause
        PORTE -> RXTX |= (1<<10); // RES =1
        pause(20); // pause
        PORTE -> RXTX |= (1<<4); // E2 - 1 set to on crystal 1 and 2
        PORTE -> RXTX |= (1<<5); // E1 - 1
        PORTE -> RXTX &= ~(1<<11); // A0 - 0
        PORTC -> RXTX &= ~(1<<2); // R/W -0
        PORTC -> RXTX |= (1<<7); // strobbing on
        PORTA -> RXTX = 0x3f; // DB0-DB7
        pause(2); // pause
        PORTC -> RXTX &= ~(1<<7); // strobbing off
        pause(2); // pause
        PORTE -> RXTX &= ~(1<<11); // A0 - 0
        PORTC -> RXTX &= ~(1<<2); // R/W - 0
        PORTC -> RXTX |= (1<<7); // strobbing on
        PORTA -> RXTX = 0xF0; // DB0-DB7
        pause(2);

        //out on screen
        PORTC -> RXTX &= ~(1<<7); // strobbing off
        pause(2); // pause
        clean(); // clean display

        printOnScreen(2, 0, 26);
        printOnScreen(2, 1, 26);
        printOnScreen(2, 2, 7); // print on screen HELLO WORLD on center of screen
        printOnScreen(2, 3, 4); // screen is 16 x 8 HW message - 11 symbols
        printOnScreen(2, 4, 11); // for centering start it from 3(2 from 0), just set on first 2 positions blank space
        printOnScreen(2, 5, 11);
        printOnScreen(2, 6, 14);
        printOnScreen(2, 7, 26);
        printOnScreen(2, 8, 22);
        printOnScreen(2, 9, 14);
        printOnScreen(2, 10, 17);
        printOnScreen(2, 11, 11);
        printOnScreen(2, 12, 3);
}

