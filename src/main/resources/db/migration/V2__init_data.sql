INSERT INTO public.users (id, email, password, status, first_name, last_name, date_of_birth, present_address, permanent_address, phone_number, city, country, state, profile_picture_url, cover_picture_url, is_delete, last_login, created_at, last_modified) VALUES ('e1930b0b-1bdf-40b6-8185-c7f27686ca2d', 'john.doe@example.com', '$2a$10$80U1Fbv7nFrd0Bfkssab8OWZvUrZ3peuAa6VxLK0B9YzQIDZb68.u', null, 'string', 'string', null, null, null, '635261389202', null, null, null, 'http://res.cloudinary.com/dunemoydy/image/upload/v1729500533/avatar/e1930b0b-1bdf-40b6-8185-c7f27686ca2d.jpg', null, false, '2024-10-21 15:48:17.445331', '2024-10-21 08:32:06.081967', '2024-10-21 15:49:38.194418');

INSERT INTO public.post (id, user_id, content, parent_post_id, is_delete, created_at, last_modified) VALUES ('7e765113-27a5-47d5-b20d-5b24328104a8', 'e1930b0b-1bdf-40b6-8185-c7f27686ca2d', 'asdksadkasjdklasd', null, false, '2024-10-21 15:17:16.058031', '2024-10-21 15:17:16.058031');
INSERT INTO public.post (id, user_id, content, parent_post_id, is_delete, created_at, last_modified) VALUES ('02232609-df96-4a6f-be70-58c0b4ef749e', 'e1930b0b-1bdf-40b6-8185-c7f27686ca2d', 'lsadjaskldjsajdaskdjsakljdsakllllllllllkssssssssssssssssssssssssssssssssssssssss', null, false, '2024-10-21 15:33:34.983193', '2024-10-21 15:33:34.983193');

INSERT INTO public.media (id, post_id, media_type, media_url, is_delete, created_at, last_modified) VALUES ('ae757bff-fd64-4228-b0b1-2352c56abc5f', '7e765113-27a5-47d5-b20d-5b24328104a8', 'VIDEO', 'http://res.cloudinary.com/dunemoydy/video/upload/v1729498597/post/7e765113-27a5-47d5-b20d-5b24328104a8/ae757bff-fd64-4228-b0b1-2352c56abc5f.mp4', false, '2024-10-21 15:17:16.074023', '2024-10-21 15:17:22.393321');
INSERT INTO public.media (id, post_id, media_type, media_url, is_delete, created_at, last_modified) VALUES ('972379af-70ee-4f02-ab1a-9fe58e2dfefe', '02232609-df96-4a6f-be70-58c0b4ef749e', 'VIDEO', 'http://res.cloudinary.com/dunemoydy/video/upload/v1729499575/post/02232609-df96-4a6f-be70-58c0b4ef749e/972379af-70ee-4f02-ab1a-9fe58e2dfefe.mp4', false, '2024-10-21 15:33:34.997703', '2024-10-21 15:33:40.281289');
INSERT INTO public.media (id, post_id, media_type, media_url, is_delete, created_at, last_modified) VALUES ('a2269dcc-aa37-4ea1-951d-eae7ae8a91c3', '02232609-df96-4a6f-be70-58c0b4ef749e', 'IMAGE', 'http://res.cloudinary.com/dunemoydy/image/upload/v1729499579/post/02232609-df96-4a6f-be70-58c0b4ef749e/a2269dcc-aa37-4ea1-951d-eae7ae8a91c3.png', false, '2024-10-21 15:33:40.289397', '2024-10-21 15:33:43.211856');


INSERT INTO public.boarding_house (id, user_id, boarding_house_name, present_address, ward, city, is_delete, created_at, last_modified) VALUES ('99e30e8b-5968-4be9-97b9-b40d0486d822', 'e1930b0b-1bdf-40b6-8185-c7f27686ca2d', 'test1', 'a', 'b', 'c', false, '2024-10-21 08:35:20.744175', '2024-10-21 08:35:20.744175');
INSERT INTO public.boarding_house (id, user_id, boarding_house_name, present_address, ward, city, is_delete, created_at, last_modified) VALUES ('cceb4ea1-1502-4863-806e-19f4273cfde6', 'e1930b0b-1bdf-40b6-8185-c7f27686ca2d', 'string', 'string', 'string', 'string', false, '2024-10-21 13:54:01.653076', '2024-10-21 13:54:01.653076');
INSERT INTO public.boarding_house (id, user_id, boarding_house_name, present_address, ward, city, is_delete, created_at, last_modified) VALUES ('c759edfc-8e80-4aa9-933e-8801f2629419', 'e1930b0b-1bdf-40b6-8185-c7f27686ca2d', 'string1', 'string', 'string', 'string', false, '2024-10-21 13:57:28.451134', '2024-10-21 13:57:28.451134');

INSERT INTO public."like" (id, user_id, post_id, last_modified, created_at) VALUES ('96838f65-a04e-4f3f-bcb0-03540ec24032', 'e1930b0b-1bdf-40b6-8185-c7f27686ca2d', '7e765113-27a5-47d5-b20d-5b24328104a8', '2024-10-21 15:53:53.903129', '2024-10-21 15:53:53.903129');

INSERT INTO public.setting (id, key, value, created_at, last_modified) VALUES ('a66aa00d-db57-41ce-a2e6-73699318d0a9', 'MAX_REPORTS', '5', '2024-10-21 13:48:55.034981', '2024-10-21 13:48:55.034981');
INSERT INTO public.setting (id, key, value, created_at, last_modified) VALUES ('f362ab8c-af3e-47ff-9665-fd85eb046ddd', 'APPROVE_TIME', '100000', '2024-10-21 13:49:17.053450', '2024-10-21 13:49:17.053450');

