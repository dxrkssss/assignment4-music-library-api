CREATE TABLE media (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL UNIQUE,
    type TEXT NOT NULL,
    duration INTEGER NOT NULL
);

CREATE TABLE playlist (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL UNIQUE
);

CREATE TABLE playlist_media (
    playlist_id INTEGER NOT NULL,
    media_id INTEGER NOT NULL,
    PRIMARY KEY (playlist_id, media_id),
    FOREIGN KEY (playlist_id) REFERENCES playlist(id),
    FOREIGN KEY (media_id) REFERENCES media(id)
);

INSERT INTO media (name, type, duration) VALUES
('Save Your Tears', 'SONG', 216),
('nuts', 'SONG', 85),
('Java Basics', 'PODCAST', 1800);

INSERT INTO playlist (name) VALUES
('songs'),
('podcasts');

INSERT INTO playlist_media (playlist_id, media_id) VALUES
(1, 1),
(1, 2),
(2, 3);