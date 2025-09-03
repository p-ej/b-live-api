CREATE TABLE spot
(
    spot_id          BIGSERIAL PRIMARY KEY,
    name             VARCHAR(255)   NOT NULL,
    description      TEXT,
    lat              DECIMAL(10, 7) NOT NULL,
    lng              DECIMAL(10, 7) NOT NULL,
    category_id      BIGINT         NOT NULL,
    popularity_score INT,          -- 인기도 (조회/리뷰/좋아요 기반)
    visit_duration   INT,          -- 권장 체류 시간 (분)
    region           VARCHAR(100), -- 행정구역 단위 (부산, 제주 등)
    created_at       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at       TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

--카테고리
CREATE TABLE category
(
    id   BIGSERIAL PRIMARY KEY,
    code VARCHAR(50)  NOT NULL UNIQUE,
    name VARCHAR(255) NOT NULL
);


CREATE TABLE tag
(
    tag_id BIGSERIAL PRIMARY KEY,
    name   VARCHAR(100) NOT NULL, -- "연인과함께", "바다", "야경"
    type   VARCHAR(50)  NOT NULL  -- "테마", "분위기", "계절", "지역"
);

CREATE TABLE spot_tag
(
    spot_id BIGINT NOT NULL,
    tag_id  BIGINT NOT NULL,
    PRIMARY KEY (spot_id, tag_id),
    FOREIGN KEY (spot_id) REFERENCES spot (spot_id),
    FOREIGN KEY (tag_id) REFERENCES tag (tag_id)
);
CREATE TABLE spot_relation
(
    spot_id_from    BIGINT NOT NULL,
    spot_id_to      BIGINT NOT NULL,
    distance_km     DECIMAL(5, 2), -- 직선거리 or 도로거리
    travel_time_min INT,           -- 이동시간 (분)
    PRIMARY KEY (spot_id_from, spot_id_to),
    FOREIGN KEY (spot_id_from) REFERENCES spot (spot_id),
    FOREIGN KEY (spot_id_to) REFERENCES spot (spot_id)
);
CREATE TABLE course
(
    course_id        BIGSERIAL PRIMARY KEY,
    name             VARCHAR(255),  -- "부산 연인과 함께하는 바다 코스"
    description      TEXT,
    total_duration   INT,           -- 전체 예상 소요시간
    total_distance   DECIMAL(5, 2), -- 총 이동 거리
    popularity_score INT,
    created_at       TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

