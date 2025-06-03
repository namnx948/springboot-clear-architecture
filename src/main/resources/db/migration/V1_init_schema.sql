create table users(
    id UUID primary key,
    username varchar(50) unique not null ,
    email varchar(100) unique not null ,
    password_hash text not null ,
    full_name varchar(100) not null ,
    bio text,
    avatar_url text,
    created_at timestamp not null default now()
);

create table follows(
    follower_id uuid references users(id) on delete cascade,
    followee_id uuid references users(id) on delete cascade,
    created_at timestamp default now(),
    primary key (follower_id, followee_id)
);

create table posts(
    id uuid primary key,
    user_id uuid references users(id),
    content text not null ,
    tags text[],
    created_at timestamp default now()
);

create table post_likes(
    user_id uuid references users(id) on delete cascade,
    post_id uuid references posts(id) on delete cascade,
    created_at timestamp default now()
);

create table comments(
    id uuid primary key ,
    post_id uuid references posts(id) on delete cascade,
    user_id uuid references users(id) on delete cascade,
    content text not null ,
    created_at timestamp default now()
);

create table messages(
    id uuid primary key ,
    sender_id uuid references users(id),
    receiver_id uuid references users(id),
    content text not null,
    sent_at timestamp default now(),
    is_read boolean default false
);

create table notifications(
    id uuid primary key ,
    user_id uuid references users(id),
    type varchar(50), --e.g. 'like', 'comment', 'follow'
    source_id uuid, -- ID của bài viết/ người dùng liên quan
    message text,
    is_read boolean default false,
    created_at timestamp default now()
);

create table email_tokens(
    token uuid primary key ,
    user_id uuid references users(id),
    type varchar(50), -- e.g. 'verify', 'reset'
    expired_at timestamp,
    used boolean default false
)
