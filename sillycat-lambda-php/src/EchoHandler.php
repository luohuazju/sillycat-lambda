<?php

declare(strict_types = 1);
namespace SillycatAPI;

require __DIR__ . '/../vendor/autoload.php';

use Bref\Context\Context;
use Bref\Event\Handler;

class EchoHandler implements Handler
{

    public function handle($event, Context $context)
    {
        $name = $event['name'];
        $articleService = new ArticleService();
        return $articleService->sayHello($name);
    }
}

return new EchoHandler();