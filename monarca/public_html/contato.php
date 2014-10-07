<?php
    $emaildestinatario = 'ariadnert@rumocertoconsultoria.com';
    //$emaildestinatario = 'jeronimo@codde.com.br,ariadnert@rumocertoconsultoria.com,projetos@codde.com.br,fernanda@codde.com.br';
    $emailsender = 'ariadnert@rumocertoconsultoria.com';//$_POST['email'];
    $quebra_linha = "\r\n";
    
    $headers = "MIME-Version: 1.1\n";
    // Para enviar o e-mail em formato HTML com codificação de caracteres Europeu Ocidental (usado no Brasil)
    //$headers .= "Content-type: text/html; charset=iso-8859-1\n";
    // Para enviar o e-mail em formato HTML com codificação de caracteres Unicode (Usado em todos os países)
    $headers .= "Content-type: text/html; charset=utf-8\n";
    // E-mail que receberá a resposta quando se clicar no 'Responder' de seu leitor de e-mails
    $headers .= "From: ".$emailsender."\n";
    $headers .= "Reply-To: ".$emailsender."\n";
    
    $texto = '';
    $texto .= '<b>Nome:</b> ' . $_POST['nome'].'<br>';
    $texto .= '<b>E-mail:</b> '.$_POST['email'].'<br>';
    $texto .= '<b>Telefone:</b> '.$_POST['telefone'].'<br>';
    $texto .= '<b>Cidade:</b> '.$_POST['cidade'].'<br>';
    $texto .= '<b>Mensagem:</b> '.nl2br($_POST['mensagem']);
    
    if(!mail($emaildestinatario, 'Contato do site', $texto, $headers ,"-r".$emailsender)){ // Se for Postfix
        $headers .= "Return-Path: " . $emailsender . $quebra_linha; // Se "não for Postfix"
        mail($emaildestinatario, 'Contato do site', $texto, $headers );
    }
?>

