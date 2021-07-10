<?php declare(strict_types=1);

namespace SillycatAPI;

require __DIR__ . '/../vendor/autoload.php';

use Nyholm\Psr7\Response;
use Psr\Http\Message\ResponseInterface;
use Psr\Http\Message\ServerRequestInterface;
use Psr\Http\Server\RequestHandlerInterface;

class CreateArticleHandler implements RequestHandlerInterface
{

    public function handle(ServerRequestInterface $request): ResponseInterface
    {
        $json_string = $request->getBody()->getContents();
        echo $json_string;

        $json = json_decode($json_string, true);

        $name = $json['name'];
        echo $name;
        
        $articleService = new ArticleService();
        $response = $articleService->sayHello($name);

        return new Response(200, [], "post $response");
    }
}

return new CreateArticleHandler();

