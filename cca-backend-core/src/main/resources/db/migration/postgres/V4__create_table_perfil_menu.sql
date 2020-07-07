create table perfil_menu(
    idperfilmenu serial,
    idperfil integer,
    idmenu integer,
    primary key (idperfil, idmenu)
);