#### CREATE TABLE players (
    player_id        SERIAL PRIMARY KEY,
    name             VARCHAR(100) NOT NULL,
    is_ai            BOOLEAN     NOT NULL DEFAULT FALSE,
    turn_order       INT         NOT NULL
);

#### CREATE TABLE units (
    unit_id           SERIAL PRIMARY KEY,
    player_id         INT        NOT NULL REFERENCES players(player_id),
    type              VARCHAR(50) NOT NULL,
    health            INT        NOT NULL CHECK (health >= 0),
    last_updated_turn INT        NOT NULL
);

#### CREATE TABLE game_state (
    state_id      SERIAL PRIMARY KEY,
    current_turn  INT       NOT NULL,
    status        VARCHAR(20) NOT NULL CHECK (status IN ('waiting','in_progress','completed')),
    last_saved    TIMESTAMP NOT NULL DEFAULT NOW()
);

